package kr.co.ync.project.view.member;

import kr.co.ync.project.Controller.MemberController;
import kr.co.ync.project.Controller.listener.MemberListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberView extends JFrame implements MemberListener{
    public static final Dimension SIZE = new Dimension(1000, 500);

    private final String[] labelTexts = {"이메일", "이름", "전화번호", "생년월일"};

    private JTextField[] fields;
    private JButton regButton;
    private JTable jTable;
    private DefaultTableModel defaultTableModel;

    public MemberView(String title) {
        super(title);
        JPanel jPanel = new JPanel(
                new GridLayout(1, 2));
        jPanel.add(createLeftPanel());
        jPanel.add(createRightPanel());
        add(jPanel);

        MemberController.getInstance().addMemberListener(this);
    }

    private JPanel createLeftPanel() {
        fields = new JTextField[labelTexts.length];
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setBounds(15, 5, 450, 180);
        fieldPanel.setLayout(new GridLayout(4, 2, 5, 5));
        fieldPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("회원등록"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        for (int i = 0; i < fields.length; i++) {
            JLabel jLabel = new JLabel(labelTexts[i], SwingConstants.LEFT);
            fields[i] = new JTextField();
            fieldPanel.add(jLabel);
            fieldPanel.add(fields[i]);
        }

        regButton = new JButton("등록");
        regButton.setBounds(30, 186, 450, 40);

        jPanel.add(fieldPanel);
        jPanel.add(regButton); // regButton을 jPanel에 추가
        return jPanel;
    }

    private JPanel createRightPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        jPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("회원목록"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        JScrollPane jScrollPane = new JScrollPane();
        defaultTableModel = new DefaultTableModel(
                new String[]{
                        "No", "이메일", "이름", "전화번호", "생년월일", "가입일"
                }, 0
        );

        jTable = new JTable(defaultTableModel);

        jScrollPane.setViewportView(jTable);
        jScrollPane.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        jTable.setFillsViewportHeight(true);

        jPanel.add(jScrollPane, BorderLayout.CENTER);
        return jPanel;
    }

    public static void createAndShowGUI() {
        JFrame frame = new MemberView("2005050 회원관리");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(SIZE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void register() {

    }
}
