import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BitcoinPriceChecker priceChecker = new BitcoinPriceChecker();

        double price = priceChecker.getBitconPrice();
        System.out.println("Current price of bitcoin: " + price );
        System.out.println("Quantity of bitcoin ?");
        double quantityOfBitcoin = Double.parseDouble(scanner.nextLine());
        double result = quantityOfBitcoin * price;
        System.out.println("You have " + result + " USD!");
    }
}