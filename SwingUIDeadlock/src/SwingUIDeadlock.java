import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingUIDeadlock {
	public static final String INITIAL_TEXT = "Initial Text";
	
	public static void main(String[] args) {
		final BusinessObject bo = new BusinessObject();
		bo.setText(INITIAL_TEXT);
		final JFrame frame = new JFrame("Deadlock Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());
		final JButton button = new JButton(bo.getText());
		frame.add(button, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeBusinessObject(bo);
			}
		});
		bo.addPropertyChangeListener(BusinessObject.PROP_TEXT, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				redoChangeOnBusinessObject(bo);
			}
		});
		frame.setVisible(true);
	}

	protected static void redoChangeOnBusinessObject(final BusinessObject bo) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					bo.setText(INITIAL_TEXT);
				}
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void changeBusinessObject(final BusinessObject bo) {
		try {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						bo.setText("New Text");
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			thread.setName("Background Thread");
			thread.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class BusinessObject {
		public static final String PROP_TEXT = "text";
		
		private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
		
		private String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			synchronized (this) {
				String oldText = getText();
				this.text = text;
				pcs.firePropertyChange(PROP_TEXT, oldText, getText());
			}
		}
		
		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		   pcs.addPropertyChangeListener(propertyName, listener);
		}
	}
	
}