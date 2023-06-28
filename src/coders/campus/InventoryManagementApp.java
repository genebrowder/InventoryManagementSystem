package coders.campus;

import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import com.coderscampus.domain.Product;
import com.coderscampus.service.CsvReaderService;
import com.coderscampus.service.ReportGeneratorService;


public class InventoryManagementApp {

	public InventoryManagementApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
				
		CsvReaderService csvReaderService = new CsvReaderService();
		List<Product> productList =  csvReaderService.readProductsFromFile(Path.of("productDataFile.txt"));
		
		ReportGeneratorService reportGeneratorService = new ReportGeneratorService();
		reportGeneratorService.generateLowInventoryReport((ArrayList<Product>)productList);

	}

}
