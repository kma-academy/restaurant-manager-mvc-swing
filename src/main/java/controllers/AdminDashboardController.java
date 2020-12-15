package controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import utils.IconManager;
import views.AdminDashboardView;
import views.admin.ManagerPane;
import views.admin.MenuItem;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class AdminDashboardController {

    private AdminDashboardView view;
    private MenuItem previousItem = null;
    private final ManageController emController = new EmployeeManagerController();

    public AdminDashboardController(AdminDashboardView view) {
        this.view = view;
        view.setVisible(true);
        view.initLayout();
        initMenu();
        addEvent();
    }

    public AdminDashboardView getView() {
        return view;
    }

    public void setPanel(JPanel panel) {
        for (JPanel card : view.getCards()) {
            card.setVisible(false);
        }
        panel.setVisible(true);
    }

    public void setView(AdminDashboardView view) {
        this.view = view;
    }

    private void initMenu() {
        IconManager im = new IconManager();
        MenuItem menuQLNV = new MenuItem("QLNV", im.getIcon("user_groups_25px.png"), "Quản lý nhân viên");
        MenuItem menuQLHH = new MenuItem("QLHH", im.getIcon("cardboard_box_25px.png"), "Quản lý hàng hóa");
        MenuItem menuQLDH = new MenuItem("QLDH", im.getIcon("shopping_cart_25px.png"), "Quản lý đặt hàng");
        MenuItem menuTK = new MenuItem("TK", im.getIcon("futures_25px.png"), "Thống kê");
        menuQLHH.addSubMenu(new MenuItem("QLLM", null, "Quản lý loại món"));
        menuQLHH.addSubMenu(new MenuItem("QLMA", null, "Quản lý món ăn"));
        menuQLDH.addSubMenu(new MenuItem("QLB", null, "Quản lý bàn"));
        menuQLDH.addSubMenu(new MenuItem("QLKH", null, "Quản lý khách hàng"));
        menuQLDH.addSubMenu(new MenuItem("QLDDH", null, "Quản lý đơn đặt hàng"));
        menuQLDH.addSubMenu(new MenuItem("QLS", null, "Quản lý giao hàng"));
        view.addMenu(menuQLNV, menuQLHH, menuQLDH, menuTK);
    }

    // Tạo sự kiện
    private void addEvent() {
        for (MenuItem menuItem : view.getMenuItems()) {
            menuItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    menuItem.collapseSubMenu();
                    onMenuChange(menuItem);
                }
            });
        }
    }

    private void onMenuChange(MenuItem item) {
        if (item.equals(previousItem)) {
            return;
        }
        if (!item.sameParent(previousItem)) { // Nếu cùng chung mục cha
            previousItem.closeParrentMenu(); // Ẩn các mục con
        } else if (previousItem != null) {
            previousItem.setBackground(new Color(255, 255, 255)); //Để lại màu mặc định
        }
        if (item.getSubMenu().isEmpty()) {
            item.setBackground(new Color(85, 172, 238));
        }
        previousItem = item;
        System.out.println(item.getId());
        ManagerPane pnl;
        switch (item.getId()) {
            case "QLNV":
                pnl = view.getEmployeeManagerPane();
                setPanel(pnl);
                emController.setView(pnl);
                break;
            case "QLDDH":
//                orderManager.setVisible(true);
                break;
            case "QLB":
//                tableManager.setVisible(true);
                break;
            case "QLKH":
//                customerManager.setVisible(true);
                break;
            case "QLLM":
//                foodCategoryManager.setVisible(true);
                break;
            case "QLMA":
//                foodItemManager.setVisible(true);
                break;
            default:
                setPanel(view.getHomePane());
                break;
        }
    }
}
