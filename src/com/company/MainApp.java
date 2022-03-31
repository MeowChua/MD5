package com.company;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
public class MainApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblInputText;
    private JTextArea textAreaResult;
    private JButton btnHashingText;
    private JTextArea textAreaInput;
    private JPanel panel_1;
    private JButton btnOpenFile;
    private JTextField textFieldFileUrl;
    private JButton btnHashingFile;
    private JTextArea textAreaFileHashing;
    private File file;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainApp frame = new MainApp();
                    frame.setVisible(true);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public MainApp() {
        setTitle("MD5 Hashing - stackjava.com");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 680, 436);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.panel = new JPanel();
        this.panel.setBorder(new TitledBorder(null, "Hashing String", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.panel.setBounds(10, 11, 644, 187);
        this.contentPane.add(this.panel);
        this.panel.setLayout(null);

        this.lblInputText = new JLabel("Input Text:");
        this.lblInputText.setBounds(10, 29, 93, 25);
        this.panel.add(this.lblInputText);

        this.textAreaResult = new JTextArea();
        this.textAreaResult.setBounds(385, 61, 249, 115);
        this.panel.add(this.textAreaResult);

        this.btnHashingText = new JButton("Generate >>");
        this.btnHashingText.setFont(new Font("Arial", Font.PLAIN, 12));
        this.btnHashingText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textAreaInput.getText();
                String result = MD5.getMd5(input);
                textAreaResult.setText(result);
            }
        });
        this.btnHashingText.setBounds(269, 99, 108, 31);
        this.panel.add(this.btnHashingText);

        this.textAreaInput = new JTextArea();
        this.textAreaInput.setBounds(10, 61, 249, 115);
        this.panel.add(this.textAreaInput);

        this.panel_1 = new JPanel();
        this.panel_1.setLayout(null);
        this.panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hashing File", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        this.panel_1.setBounds(10, 209, 644, 187);
        this.contentPane.add(this.panel_1);

        this.btnOpenFile = new JButton("Open File");
        this.btnOpenFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int status = fileChooser.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    textFieldFileUrl.setText(file.getAbsolutePath());
                }
            }
        });
        this.btnOpenFile.setBounds(10, 40, 116, 23);
        this.panel_1.add(this.btnOpenFile);

        this.textFieldFileUrl = new JTextField();
        this.textFieldFileUrl.setBounds(136, 40, 330, 20);
        this.panel_1.add(this.textFieldFileUrl);
        this.textFieldFileUrl.setColumns(10);

        this.btnHashingFile = new JButton("Check MD5");
        this.btnHashingFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = MD5.getMD5(file);
                textAreaFileHashing.setText(result);
            }
        });
        this.btnHashingFile.setBounds(10, 84, 116, 23);
        this.panel_1.add(this.btnHashingFile);

        this.textAreaFileHashing = new JTextArea();
        this.textAreaFileHashing.setBounds(136, 82, 330, 93);
        this.panel_1.add(this.textAreaFileHashing);
    }
}
