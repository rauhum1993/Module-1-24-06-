package controller;

import bo.BOMatBang;
import model.MatBang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = "/mat_bang")
public class MatBangServlet extends HttpServlet {
    private BOMatBang boMatBang = new BOMatBang();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                try {
                    themMoiThonTin(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "edit":
//                updateProduct(request, response);
//                break;
            default:
                danhSachMatBang(request, response);
                break;
        }
    }

    private void themMoiThonTin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String maMatBang = request.getParameter("maMatBang");
        String trangThai = request.getParameter("trangThai");
        String dienTich = request.getParameter("dienTich");
        String tang = request.getParameter("tang");
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        String giaTien = request.getParameter("giaTien");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");

        MatBang matBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiVanPhong, giaTien, ngayBatDau, ngayKetThuc);
        boMatBang.themMoiThongTin(matBang);
        request.setAttribute("notification1", "Thêm thành công 1 mặt bằng");
        List<MatBang> matBangList = boMatBang.danhSachMatBang();
        request.setAttribute("danhSachMatBang", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                themMoiMatBang(request, response);
                break;
            case "delete":
                xoaMatBang(request, response);
                break;
            case "searchMatBang":
                timLoaiMatBang(request, response);
                break;
            case "searchTang":
                timTang(request, response);
                break;
            case "searchGia":
                timGia(request, response);
                break;
            default:
                danhSachMatBang(request, response);
                break;
        }
    }

    private void timTheoGia(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangList;
        String value = request.getParameter("search1");
        matBangList = boMatBang.searchGia(value);
        request.setAttribute("notification3", "Search Results");
        request.setAttribute("danhSachMatBang", matBangList);
        try {
            request.getRequestDispatcher("view/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void timGia(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangList;
        String value = request.getParameter("searchGia");
        matBangList = boMatBang.searchGia(value);
        request.setAttribute("notification3", "Search Results");
        request.setAttribute("danhSachMatBang", matBangList);
        try {
            request.getRequestDispatcher("view/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void timTang(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangList;
        String value = request.getParameter("searchTang");
        matBangList = boMatBang.searchTang(value);
        request.setAttribute("notification3", "Search Results");
        request.setAttribute("danhSachMatBang", matBangList);
        try {
            request.getRequestDispatcher("view/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void timLoaiMatBang(HttpServletRequest request, HttpServletResponse response) {
        List<MatBang> matBangList;
        String value = request.getParameter("searchMatBang");
        matBangList = boMatBang.searchByName(value);
        request.setAttribute("notification3", "Search Results");
        request.setAttribute("danhSachMatBang", matBangList);
        try {
            request.getRequestDispatcher("view/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void xoaMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maMatBang = request.getParameter("maMatBang");
        boMatBang.delete(maMatBang);
        List<MatBang> matBangList = boMatBang.danhSachMatBang();
        request.setAttribute("notification2", "Xoa thanh cong");
        request.setAttribute("danhSachMatBang", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void danhSachMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> matBangList = boMatBang.danhSachMatBang();
        request.setAttribute("danhSachMatBang", matBangList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void themMoiMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("view/create-view.jsp");
    }
}
