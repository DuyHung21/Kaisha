/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.shop.controllers;


import com.softech.shop.model.Customers;
import com.softech.shop.model.Orders;
import com.softech.shop.services.CategoryService;
import com.softech.shop.services.CustomerService;
import com.softech.shop.services.NotificationService;
import com.softech.shop.services.OrderDetailService;
import com.softech.shop.services.OrderService;
import com.softech.shop.view_model.ChangePasswordViewModel;
import com.softech.shop.view_model.CustomerViewModel;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/users")
public class CustomerControllerClient {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/customer/register")
    public String registerForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("customer", new CustomerViewModel());
        return "/user/register";
    }

    @PostMapping("/customer/register")
    public String registerSubmit(@ModelAttribute("customer") CustomerViewModel customerViewModel, ModelMap modelMap, HttpSession session) {
        Customers customers;
        for (String email : customerService.listEmail()) {
            if (customerViewModel.getEmail().equals(email)) {
                customers = customerService.findByEmail(email);
                if (customers.getPassword() == null) {
                    if (customerViewModel.getPassword().equals(customerViewModel.getReNewPassword())) {
                        //password == reNewPassword
                        customers.setCustomerName(customerViewModel.getCustomerName());
                        customers.setEmail(customerViewModel.getEmail());
                        customers.setPassword(customerViewModel.getPassword());
                        customers.setPhone(customerViewModel.getPhone());
                        customers.setAddress(customerViewModel.getAddress());
                        customers.setTotalMoney(0L);

                        customerService.save(customers);
                        //email
//                        try {
//                            notificationService.sendMailForNewCustomer(customers);
//                        } catch (MailException ex) {
//                            System.out.println(ex.getMessage());
//                        }
                        session.setAttribute("userName", customers.getCustomerName());
                        session.setAttribute("customerId", customers.getCustomerId());
                        return "redirect:/users/";
                    } 
                    else {
                        modelMap.put("message", "Nhập lại mật khẩu không đúng, xin vui lòng thử lại lần nữa!");
                        return "/user/register";
                    }
                }
                else {
                    modelMap.put("message", "This email has been registered, please try another email!");
                    return "/user/register";
                }

            }
        }
        if (customerViewModel.getPassword().equals(customerViewModel.getReNewPassword())) {
            //password == reNewPassword
            customers = new Customers();
            customers.setCustomerName(customerViewModel.getCustomerName());
            customers.setEmail(customerViewModel.getEmail());
            customers.setPassword(customerViewModel.getPassword());
            customers.setPhone(customerViewModel.getPhone());
            customers.setAddress(customerViewModel.getAddress());
            customers.setTotalMoney(0L);

            customerService.save(customers);
            try {
                notificationService.sendMailForNewCustomer(customers);
            } catch (MailException ex) {
                System.out.println(ex.getMessage());
            }
            session.setAttribute("userName", customers.getCustomerName());
            session.setAttribute("customerId", customers.getCustomerId());
            return "redirect:/users/";
        } else {
            modelMap.put("message", "Nhập lại mật khẩu không đúng, xin vui lòng thử lại lần nữa!");
            return "/user/register";
        }
    }

    @GetMapping("/customer/success")
    public String success(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        return "/user/success";
    }

    @GetMapping("/customer/login")
    public String loginForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("customer", new Customers());
        return "/user/login";
    }

    @PostMapping("/customer/login")
    public String loginSubmit(@ModelAttribute("customer") Customers customerView, ModelMap modelMap, HttpSession session) {
        Customers customer = customerService.findByEmail(customerView.getEmail());
        if (customer != null) {
            if (customer.getPassword().equals(customerView.getPassword())) {
                //login success
                session.setAttribute("userName", customer.getCustomerName());
                session.setAttribute("customerId", customer.getCustomerId());
                return "redirect:/users/";
            } else {
                //password wrong
                modelMap.put("message", "Wrong password, please try again!");
                return "/user/login";
            }
        } else {
            //wrong email
            modelMap.put("message", "Wrong email, please try again!");
            return "/user/login";
        }
    }

    @GetMapping("/customer/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("userName") != null) {
            session.removeAttribute("userName");
            session.removeAttribute("customerId");
            return "redirect:/users/customer/login";
        }
        return "redirect:/users/";
    }
}
