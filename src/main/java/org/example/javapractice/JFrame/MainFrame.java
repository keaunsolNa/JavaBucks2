package org.example.javapractice.JFrame;

import org.example.javapractice.CommonModule.CommonModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * MainFrame 을 만들고, 버튼에 대한 Action 을 정의하는 클래스
 * @author keaunsolNa
 * @version 1.0
 */
public class MainFrame extends JFrame implements ActionListener {

    // member variable area
    private final String PATH = "org.example.javapractice.dto";
    private final String[] pkgPath = new String[3];
    private final int[] options = new int[] {1, 1, 1, 1, 1, 0};            // Iced/Hot, 개별메뉴여부, 옵션메뉴활성화여부, Size, IceOnly 여부, Short 사이즈 포함 여부
    private final CommonModule cm = new CommonModule();
    private final Stack<JPanel> prevMenu = new Stack<>();
    private Map<String, List<String>> menuMap;
    private List<String> levelOneList, levelTwoList, levelThrList, optionList;
    private JPanel mainPanel, bottomPanel;
    private String chosenDtoPath, chosenMenu;

    // Constructor
    public MainFrame() {
    }

    /**
     *  Main method 에서 호출하는 메서드. 최초 구동 시 MainFrame 생성한다.
     *  뒤로 가기 버튼, 초기 메뉴, 하단 옵션 선택 버튼을 통해 메인 페널을 만든다.
     */
    public void makeMainFrame()
    {
        setSize(500, 600);
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
        levelOneList = Arrays.asList(btn);

        btn = new String[] {"Iced", "Hot", "Short", "Tall", "Grande", "Venti"};
        optionList = Arrays.asList(btn);
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        makeDefaultButton(bottomPanel, btn, false);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        prevMenu.push(mainPanel);
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
            tempBtn.setVisible(isEnable);

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
        String DTO_PATH = "src/main/java/org/example/javapractice/dto/";

        // 뒤로 가기 버튼
        if (command.equals("GoBack"))
        {
            // 옵션 메뉴 활성화 된 상태일 경우 별도 처리
            if (options[2] == 0)
            {
                String temp = pkgPath[1];
                goBackPanel();
                pkgPath[1] = temp;
            }
            else
            {
                goBackPanel();
                if (pkgPath[2] != null)  pkgPath[2] = null;
                else if (pkgPath[1] != null) pkgPath[1] = null;
                else pkgPath[0] = null;
            }
        }

        // Hot, Cold, Size 조정 등 옵션 선택
        else if (optionList.contains(command))
        {

            switch (command)
            {
                case "Iced" : options[0] = 1; break;
                case "Hot" : options[0] = 0; break;
                case "Short" : options[3] = 0; break;
                case "Tall" : options[3] = 1; break;
                case "Grande" : options[3] = 2; break;
                case "Venti" : options[3] = 3; break;
            }

            // 최초 옵션 지정 시에만
            if (options[2] == 1)
            {
                options[2] = 0;
                pkgPath[2] = null;
            }

            MakeMenuNameByOption(chosenMenu);
        }

        // Drink, Food, Merchandise 버튼 선택 시 해당 메뉴의 하위 메뉴를 가져온다.
        else if (levelOneList.contains(command))
        {
            levelTwoList = cm.getPackageNameFromPackage(DTO_PATH + command);
            updatePanel(levelTwoList);
            pkgPath[0] = command;
            chosenDtoPath = command + "/";

        }

        /*
            Drink, Food, Merchandise 버튼의 하위 버튼 선택 시 해당 버튼의 하위 메뉴 중 default 객체를 가져온다. (Size 를 제외한 원형 객체)
            가져오는 방식은 Map<String, List<String>> 형태
            Map의 key가 각 메뉴의 원형 객체가 된다.
            원형 객체는 원형 객체를 상속받은 세부 객체가 되며, 세부 객체는 각각 Iced, Hot, Size(Tall, Grande, Venti) 등의 옵션에 따라 세부객체가 나뉜다.
         */
        else if (levelTwoList.contains(command))
        {
            menuMap = cm.getMenuMap(DTO_PATH + chosenDtoPath + command, PATH + makeArrPkgPathToStringPath() + "." + command);
            levelThrList = menuMap.keySet().stream().toList();
            updatePanel(levelThrList);
            pkgPath[1] = command;
        }

        // 개별 매뉴 선택 시 들어오는 이벤트
        else if (levelThrList.contains(command))
        {

            if (menuMap.get(command).get(1).contains("Short")) options[5] = 0;
            else options[5] = 1;

            chosenMenu = command;
            MakeMenuNameByOption(command);
            pkgPath[2] = command;
        }
    }

    /**
     * 버튼 선택 시 기존 패널을 제거하고 선택된 버튼의 하위 버튼으로 새로운 패널을 생성한다.
     *
     * @param btnList 생성할 버튼의 리스트
     */
    private void updatePanel(List<String> btnList) {

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
        prevMenu.push(mainPanel);               // 이전 프레임 Stack에 저장
        getContentPane().remove(mainPanel);     // 메인 패널 remove
        mainPanel = newPanel;                   // 새로운 패널을 메인 패널로 교체
        add(mainPanel, BorderLayout.CENTER);    // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기

    }

    /**
     * 메뉴 선택 시 해당 메뉴의 이미지와 정보를 가져오는 메서드
     *
     * @param path : 메뉴의 이미지 주소
     * @param menu : 메뉴의 이름
     */
    private void updateMenuPanel(String path, String menu)
    {
        ImageIcon icon = new ImageIcon(path);
        JPanel newPanel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };

        Map<String, Object> map = cm.getInfoMapFromDynamicClass(PATH + makeArrPkgPathToStringPath() + "." + menu);
        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet())
        {
            if (key.equals("icedOnly") && (boolean) map.get(key))
            {
                options[4] = 0;
            }

            else
            {
                sb.append("<p>").append(key).append(" : ").append(map.get(key)).append("</p><br/>");
            }
        }

        JLabel label = new JLabel("<html><body>" + sb + "</body></html>");

        newPanel.add(label, BorderLayout.EAST);
        newPanel.doLayout();
        newPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10)); // 좌측 정렬

        // 기존 패널을 제거하고 새 패널로 교체
        if (options[1] == 1)
        {
            prevMenu.push(mainPanel);           // 이전 프레임 Stack에 저장
        }
        getContentPane().remove(mainPanel);     // 메인 패널 remove
        mainPanel = newPanel;                   // 새로운 패널을 메인 패널로 교체
        add(mainPanel, BorderLayout.CENTER);    // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기
        options[1] = 0;

        // 메뉴 진입 시 옵션 버튼 활성화
        for (Component comp : bottomPanel.getComponents())
        {
            if (comp instanceof JButton btn)
            {
                if (options[4] == 0 && (btn.getActionCommand().equals("Hot") || btn.getActionCommand().equals("Iced"))) continue;

                comp.setVisible(true);

                if (options[5] != 0 && btn.getActionCommand().equals("Short")) btn.setVisible(false);
                if (options[5] == 0 && btn.getActionCommand().equals("Venti")) btn.setVisible(false);
            }
        }

    }

    /**
     * 
     * 뒤로 가기, 옵션 등 버튼 선택 시 변화하는 패키지 경로 대응하기 위해 경로 배열 형태로 설정
     * 배열 형태의 경로를 스트링 형태로 반환
     * 이 때 아직 들어가지 않은 루트의 경로는 무시
     *
     * @return pkgPath : 패키지 경로
     */
    private String makeArrPkgPathToStringPath()
    {
        StringBuilder sb = new StringBuilder();
        for (String str : pkgPath)
        {
            if (str == null) break;
            sb.append(".").append(str);
        }
        return sb.toString();
    }

    /**
     * 뒤로가기 버튼.
     * 기존 패널을 제거하고 이전의 패널로 교체한다.
     */
    private void goBackPanel()
    {

        // 뒤로가기 시 이전 패널이 없다면 void return
        if (prevMenu.isEmpty())
        {
            return;
        }

        // 기존 패널을 제거하고 새 패널로 교체
        getContentPane().remove(mainPanel);     // 메인 패널 remove
        mainPanel = prevMenu.pop();             // Stack에 저장된 이전 패널을 꺼내 새로운 메인 패널로 삼는다.
        add(mainPanel, BorderLayout.CENTER);    // 새 패널을 중앙에 추가

        // 레이아웃 갱신
        revalidate();  // 레이아웃을 다시 계산
        repaint();     // 화면을 다시 그리기

        // 이전 메뉴가 개별 메뉴 정보에 대한 panel 이었을 경우, 옵션값을 초기화하고 옵션 버튼을 비활성화한다.
        if (options[1] == 0)
        {

            Arrays.fill(options, 1);

            for (Component comp : bottomPanel.getComponents())
            {
                if (comp instanceof JButton)
                {
                    comp.setVisible(false);
                }
            }
        }
    }

    private void MakeMenuNameByOption(String command) {

        String menu = (options[3] == 0 ? "Short" : options[3] == 1 ? "Tall" : options[3] == 2 ? "Grande" : "Venti") + (options[0] == 1 ? "Iced" : "") + command;
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\" + makeArrPkgPathToStringPath().split("\\.")[1] + "\\" + makeArrPkgPathToStringPath().split("\\.")[2] + "\\" + (options[0] == 1 ? "Iced" : "") + command + ".jpg";

        updateMenuPanel(path, menu);
    }
}
