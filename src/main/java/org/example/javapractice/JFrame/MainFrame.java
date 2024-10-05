package org.example.javapractice.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.javapractice.CommonModule.CommonModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame implements ActionListener {

    private static final Logger log = LogManager.getLogger(MainFrame.class);
    private static final String PATH = "org.example.javapractice.dto";
    private static final String DTO_PATH = "src/main/java/org/example/javapractice/dto/";
    private static final StringBuilder pkgPath = new StringBuilder();
    private static final CommonModule cm = new CommonModule();
    private JPanel mainPanel, prevPanel;

    // 최초 Init 시 메인 프레임
    public MainFrame() {

        log.info("MAINFRAME START");
        setSize(150, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton btnBack = new JButton("<-");
        btnBack.setActionCommand("GoBack");
        btnBack.addActionListener(this);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(btnBack);

        add(topPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

        JButton btn1 = new JButton("Drink");
        btn1.setActionCommand("Drink");
        btn1.addActionListener(this);

        JButton btn2 = new JButton("Food");
        btn2.setActionCommand("Food");
        btn2.addActionListener(this);

        JButton btn3 = new JButton("Merchandise");
        btn3.setActionCommand("Merchandise");
        btn3.addActionListener(this);

        mainPanel.add(btn1);
        mainPanel.add(btn2);
        mainPanel.add(btn3);

        add(mainPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);

        prevPanel = mainPanel;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        log.info(command);
        switch (command)
        {

            case "Drink" :
            case "Food" :
            case "Merchandise" :
                List<String> directoryList = cm.getPackageNameFromPackage(DTO_PATH + command, false);
                updatePanel(directoryList);
                pkgPath.append(".").append(command);
                break;

            case "ColdBrew" :
            case "Espresso" :
            case "Frappuccino" :
                List<String> classList = cm.getPackageNameFromPackage(DTO_PATH + "DRINK/" + command, true);
                updatePanel(classList);
                pkgPath.append(".").append(command);
                break;


            case "GoBack" :
                goBackPanel();
                pkgPath.delete(pkgPath.lastIndexOf("."), pkgPath.length());
                break;

            default: Map<String, Object> map = cm.getInfoMapFromDynamicClass(PATH + pkgPath + "." + command);
                System.out.println(map);
        }
        System.out.println(PATH + pkgPath);
    }

    // 버튼 선택 시 패널 업데이트
    public void updatePanel(List<String> btnList) {

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // 좌측 정렬

        for (String s : btnList)
        {
            JButton tempBtn = new JButton(s);
            tempBtn.setActionCommand(s);
            tempBtn.addActionListener(this);
            newPanel.add(tempBtn);
        }

        // 기존 패널을 제거하고 새 패널로 교체
        prevPanel = mainPanel;               // 기존 메인 패널 제거 전 이전 프레임으로 담아두기
        getContentPane().remove(mainPanel);  // 기존 메인 패널 제거
        mainPanel = newPanel;                // 새로운 패널을 메인 패널로 교체
        add(mainPanel, BorderLayout.CENTER); // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기

    }

    // 뒤로가기 버튼
    private void goBackPanel()
    {
        log.info("GoBack");

        // 기존 패널을 제거하고 새 패널로 교체
        getContentPane().remove(mainPanel);     // 기존 메인 패널 제거
        mainPanel = prevPanel;                  // 새로운 패널을 메인 패널로 교체
        add(mainPanel, BorderLayout.CENTER);    // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기
    }
}
