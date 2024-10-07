package org.example.javapractice.JFrame;

import org.example.javapractice.CommonModule.CommonModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * MainFrame 을 만들고, 버튼에 대한 Action 을 정의하는 클래스
 * @author keaunsolNa
 * @version 1.0
 */
public class MainFrame extends JFrame implements ActionListener {

    // global variable area
    private static final String PATH = "org.example.javapractice.dto",
                                DTO_PATH = "src/main/java/org/example/javapractice/dto/";
    private static final StringBuilder pkgPath = new StringBuilder();
    private static final CommonModule cm = new CommonModule();
    private static List<String> nowList, menuList;
    private JPanel mainPanel, prevPanel;
    private static String chosenDtoPath;

    // Constructor
    public MainFrame() {
    }

    /**
     *  Main method 에서 호출하는 메서드. 최초 구동 시 MainFrame 생성한다.
     *
     */
    public void makeMainFrame()
    {
        setSize(500, 500);
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

        String[] btn = new String[] { "Drink", "Food", "Merchandise"};
        makeDefaultButton(mainPanel, btn, true);
        add(mainPanel, BorderLayout.CENTER);
        menuList = Arrays.asList(btn);

        btn = new String[] {"Iced", "Hot", "Tall", "Grande", "Venti"};
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        makeDefaultButton(bottomPanel, btn, false);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        prevPanel = mainPanel;
        setVisible(true);
    }

    /**
     *
     * String 배열을 받아 해당하는 버튼을 만든 뒤 반환한다.
     * ActionCommand 는 버튼의 제목이다.
     *
     * @param  panel 버튼이 생성될 J패널
     * @param  buttons 생성될 버튼들의 리스트
     * @param  isEnable 버튼의 Enabled 초기값
     */
    private void makeDefaultButton (JPanel panel, String[] buttons, boolean isEnable)
    {

        for (String str : buttons)
        {
            JButton tempBtn = new JButton(str);
            tempBtn.setActionCommand(str);
            tempBtn.addActionListener(this);
            tempBtn.setEnabled(isEnable);

            panel.add(tempBtn);
        }
    }

    /**
     *
     * ActionListener 의 구체 메서드, 이벤트 발생 시 수행할 동작을 정의한다.
     *
     * @param e 눌려진 버튼의 이벤트 이름
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // 뒤로 가기 버튼
        if (command.equals("GoBack"))
        {
            goBackPanel();
            pkgPath.delete(pkgPath.lastIndexOf("."), pkgPath.length());
        }

        // Drink, Food, Merchandise 버튼 선택 시 해당 메뉴의 하위 메뉴를 가져온다.
        else if (menuList.contains(command))
        {
            nowList = cm.getPackageNameFromPackage(DTO_PATH + command);
            updatePanel(nowList);
            pkgPath.append(".").append(command);
            chosenDtoPath = command + "/";

        }

        // Drink, Food, Merchandise 버튼의 하위 버튼 선택 시 해당 버튼의 하위 메뉴 중 default 객체를 가져온다. (Size 를 제외한 원형 객체)
        else if (nowList.contains(command))
        {
            Map<String, List<String>> classList = cm.getMenuMap(DTO_PATH + chosenDtoPath + command, PATH + pkgPath + "." + command);
            System.out.println(classList);
//            updatePanel(classList);
            pkgPath.append(".").append(command);
        }

        // 메뉴 선택 시 해당 메뉴의 정보를 가져온다.
//            default: Map<String, Object> map = cm.getInfoMapFromDynamicClass(PATH + pkgPath + "." + command);
//                System.out.println(map);
//        }
    }

    /**
     *
     * 버튼 선택 시 기존 패널을 제거하고 선택된 버튼의 하위 버튼으로 새로운 패널을 생성한다.
     *
     * @param btnList 생성할 버튼의 리스트
     */
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

    /**
     * 뒤로가기 버튼.
     * 기존 패널을 제거하고 이전의 패널로 교체한다.
     */
    private void goBackPanel()
    {
        // 기존 패널을 제거하고 새 패널로 교체
        getContentPane().remove(mainPanel);     // 기존 메인 패널 제거
        mainPanel = prevPanel;                  // 새로운 패널을 메인 패널로 교체
        add(mainPanel, BorderLayout.CENTER);    // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기
    }
}
