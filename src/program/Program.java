package program;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        short amount = scanner.nextShort();
        for (int x = 1; x <= amount; x++) {
            System.out.println("Product #" + x + " data:");
            System.out.print("Common, used or imported (c/u/i) ?:");
            String prod = scanner.next();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Price :");
            Double price = scanner.nextDouble();
            if(prod.equalsIgnoreCase("i")){
                System.out.print("Customs fee: ");
                Double customsfee = scanner.nextDouble();
                productList.add(new ImportedProduct(name,price,customsfee));
            }else if(prod.equalsIgnoreCase("u")){
                System.out.print("Manufacture Date (DD/MM/YYYY)");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date manufactureDate = simpleDateFormat.parse(scanner.next());
                productList.add(new UsedProduct(name,price,manufactureDate));
            }else{
                productList.add(new Product(name,price));
            }



        }

        scanner.close();
        System.out.println();
        for (Product obj : productList) {
            System.out.println("Name: " + obj.getName() + " $" + obj.priceTag());
        }
    }
}
