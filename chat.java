import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chat {

    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Basic Chat Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

      
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

      
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        panel.add(scrollPane, BorderLayout.CENTER);

     
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("Send");
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.SOUTH);

      
        frame.add(panel);
        frame.setVisible(true);

    
        sendButton.addActionListener(new ActionListener() {
            private boolean isUser1 = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText().trim();
                if (!message.isEmpty()) {
                    String user = isUser1 ? "User1" : "User2";
                    chatArea.append(user + ": " + message + "\n");
                    isUser1 = !isUser1; 
                    messageField.setText(""); 
                }
            }
        });

       
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick();
            }
        });
    }
}
