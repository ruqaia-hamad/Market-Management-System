package com.TechM.springDemoProject.Services;

import com.TechM.springDemoProject.Controllers.CustomerMarketDTO;
import com.TechM.springDemoProject.Controllers.DTO.*;
import com.TechM.springDemoProject.Models.Customer;
import com.TechM.springDemoProject.Models.Invoice;
import com.TechM.springDemoProject.Models.Item;
import com.TechM.springDemoProject.Models.Market;
import com.TechM.springDemoProject.Repositories.CustomerRepository;
import com.TechM.springDemoProject.Repositories.InvoiceRepository;
import com.TechM.springDemoProject.Repositories.ItemRepository;
import com.TechM.springDemoProject.Repositories.MarketRepository;
import com.TechM.springDemoProject.RequestObject.ItemInvoiceDTO;
import com.TechM.springDemoProject.RequestObject.TotalRevenueDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.repo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.swing.event.ListDataEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ReportService {
    public static final String pathToReports = "C:\\Users\\user015\\Downloads\\Reports";
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    InvoiceRepository invoiceRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<Market> marketList = marketRepository.getAllMarkets();
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Market_System.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Markets.pdf");
        return "Report generated : " + pathToReports + "\\Markets.pdf";
    }

    public String generateReportForCustomers() throws FileNotFoundException, JRException {
        List<Customer> findCustomersWithMarketName = customerRepository.getAllCustomers();
        List<CustomerMarketDTO> customerReports = new ArrayList<>();
        for (Customer customer : findCustomersWithMarketName) {
            customer.getMarket().getName();
            customer.getCustomerFirstName();
            customer.getId();
            CustomerMarketDTO customerReport = new CustomerMarketDTO(customer.getMarket().getName(), customer.getCustomerFirstName(), customer.getId());
            customerReports.add(customerReport);
        }
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Customers_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customerReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Customers.pdf");
        return "Report generated : " + pathToReports + "\\Customers.pdf";
    }

    public String generateReportForInvoices() throws FileNotFoundException, JRException {
        List<Item> itemList = itemRepository.getAllItems();
        List<ItemInvoiceDTO> invoicesReports = new ArrayList<>();
        for (Item item : itemList) {
            item.getInvoice().getId();
            item.getInvoice().getEmail();
            item.getInvoice().getFax();
            item.getInvoice().getWebsite();
            item.getName();
            ItemInvoiceDTO invoiceReport = new ItemInvoiceDTO(item.getInvoice().getId(), item.getInvoice().getEmail(), item.getInvoice().getFax(), item.getInvoice().getWebsite(), item.getName());
            invoicesReports.add(invoiceReport);

        }
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Invoices_with_items_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoicesReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Invoices.pdf");
        return "Report generated : " + pathToReports + "\\Invoices.pdf";
    }

    public String generateReportForTotal() throws FileNotFoundException, JRException {
        List<TotalRevenueDTO> marketRevenueReports = new ArrayList<>();
        List<Market> markets = marketRepository.getAllMarkets();

        for (Market market : markets) {
            List<Customer> customers = customerRepository.findByMarketId(market.getId());
            List<Invoice> invoices = new ArrayList<>();
            for (Customer customer : customers) {
                List<Invoice> customerInvoices = invoiceRepository.findByCustomerId(customer.getId());
                invoices.addAll(customerInvoices);
            }
            double totalRevenue = invoices.stream()
                    .mapToDouble(Invoice::getTotalPrice)
                    .sum();
            String name = market.getName();
            TotalRevenueDTO marketRevenueReport = new TotalRevenueDTO();
            marketRevenueReport.setName(name);
            marketRevenueReport.setTotalPrice(totalRevenue);
            marketRevenueReports.add(marketRevenueReport);
        }


        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Total_Revenue_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketRevenueReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TotalRevenue.pdf");
        return "Report generated : " + pathToReports + "\\TotalRevenue.pdf";
    }


    public String generateReportForTopSellingItem() throws FileNotFoundException, JRException {
        List<Invoice> invoices = invoiceRepository.getAllInvoices();
        List<TopSellingItemDTO> topSellingItems = new ArrayList<>();

        for (Invoice invoice : invoices) {
            List<Item> items = itemRepository.findByInvoiceId(invoice.getId());

            if (!items.isEmpty()) {
                Item topSellingItem = items.stream()
                        .max(Comparator.comparingInt(Item::getQuantity))
                        .orElseThrow();

                TopSellingItemDTO topSellingItemDTO = new TopSellingItemDTO();
                topSellingItemDTO.setInvoiceEmail(invoice.getEmail());
                topSellingItemDTO.setTopSellingItemDescription(topSellingItem.getName());

                topSellingItems.add(topSellingItemDTO);
            }
        }
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Top_Selling_Item_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topSellingItems);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopSellingItem.pdf");
        return "Report generated : " + pathToReports + "\\TopSellingItem.pdf";
    }


    public String generateReportForCustomerPerformance() throws FileNotFoundException, JRException {
        List<Customer> customerPerformanceDTOs = customerRepository.findAllCustomersWithTotalRevenue();
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\CustomerPerformance_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customerPerformanceDTOs);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CustomerPerformance.pdf");
        return "Report generated : " + pathToReports + "\\CustomerPerformance.pdf";
    }


    public String getMarketCustomerCountReport() throws FileNotFoundException, JRException {
        List<Market> markets = marketRepository.findAll();
        List<MarketCustomerCountDTO> marketCustomerCountReports = new ArrayList<>();

        for (Market market : markets) {
            List<Customer> customers = customerRepository.findByMarket(market);
            String name = market.getName();
            Integer customerCount = customers.size();
            MarketCustomerCountDTO marketCustomerCountReport = new MarketCustomerCountDTO();
            marketCustomerCountReport.setName(name);
            marketCustomerCountReport.setCustomerCount(customerCount);
            marketCustomerCountReports.add(marketCustomerCountReport);
        }
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Marker_Total_Customers.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketCustomerCountReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Marker_Total_Customers.pdf");
        return "Report generated : " + pathToReports + "\\Marker_Total_Customers.pdf";
    }


    public String generateReportForItemDistribution() throws FileNotFoundException, JRException {
        List<ItemDistributionDTO> itemDistributionDTOs = itemRepository.findItemDistribution();
        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Item_Count_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(itemDistributionDTOs);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Item_Count_Report.pdf");
        return "Report generated : " + pathToReports + "\\Item_Count_Report.pdf";
    }


    public String generateTopMarketsReport() throws FileNotFoundException, JRException {
        List<Market> markets = marketRepository.findAll();
        List<MarketPerformanceDTO> marketRevenueReports = new ArrayList<>();

        for (Market market : markets) {
            List<Customer> customers = customerRepository.findByMarket(market);
            double totalRevenue = 0;

            for (Customer customer : customers) {
                List<Invoice> invoices = invoiceRepository.findByCustomerId(customer.getId());
                for (Invoice invoice : invoices) {
                    totalRevenue += invoice.getTotalPrice();
                }
            }

            MarketPerformanceDTO marketRevenueReport = new MarketPerformanceDTO();
            marketRevenueReport.setName(market.getName());
            marketRevenueReport.setTotalRevenue(totalRevenue);
            marketRevenueReports.add(marketRevenueReport);
        }

        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Top_Performing_Markets.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketRevenueReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Top_Performing Markets.pdf");
        return "Report generated : " + pathToReports + "\\Top_Performing Markets.pdf";
    }


    public String generateReportForCustomersReport() throws FileNotFoundException, JRException {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerReportDTO> customerReports = new ArrayList<>();
        for (Customer customer : customers) {
            List<Invoice> invoices = invoiceRepository.findByCustomerId(customer.getId());
            int totalInvoices = invoices.size();
            int totalItemsSold = invoices.stream()
                    .flatMap(invoice -> invoice.getItems().stream())
                    .mapToInt(Item::getQuantity)
                    .sum();

            CustomerReportDTO customerReport = new CustomerReportDTO();
            customerReport.setName(customer.getCustomerFirstName() + " " + customer.getCustomerSecondName());
            customerReport.setContact(customer.getContact());
            customerReport.setTotalInvoices(totalInvoices);
            customerReport.setTotalItemsSold(totalItemsSold);
            customerReports.add(customerReport);
        }

        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\MarketCustomers_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customerReports);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CustomerPerformanceReport.pdf");
        return "Report generated : " + pathToReports + "\\CustomerPerformanceReport.pdf";
    }

    public String generateReportForTopSellingITemInMarket() throws FileNotFoundException, JRException {

        List<Market> markets = marketRepository.getAllMarkets();
        List<MarketItemReportDTO> marketItemReportDTOS = new ArrayList<>();

        for (Market market : markets) {
            List<Item> itemsSoldInMarket = new ArrayList<>();

            List<Customer> customers = customerRepository.findByMarketId(market.getId());
            for (Customer customer : customers) {
                List<Invoice> invoices = invoiceRepository.findByCustomerId(customer.getId());
                for (Invoice invoice : invoices) {
                    List<Item> items = itemRepository.findByInvoiceId(invoice.getId());
                    itemsSoldInMarket.addAll(items);
                }
            }

            if (!itemsSoldInMarket.isEmpty()) {
                Item topSellingItem = Collections.max(itemsSoldInMarket, Comparator.comparingInt(Item::getQuantity));
                MarketItemReportDTO marketItemReportDTO = new MarketItemReportDTO();
                marketItemReportDTO.setName(market.getName());
                marketItemReportDTO.setTopSellingItem(topSellingItem.getName());

                marketItemReportDTOS.add(marketItemReportDTO);
            }
        }

        File file = new File("C:\\Users\\user015\\Downloads\\springDemoProject\\springDemoProject\\src\\main\\resources\\Market_TopSelling_Item.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marketItemReportDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Ruqiya");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Market_TopSelling_Item.pdf");
        return "Report generated : " + pathToReports + "\\Market_TopSelling_Item.pdf";


    }

}
