import java.util.Scanner;

public class Pricecalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Shift-JIS");

        String productName = readProductName(scanner);
        int quantity = readQuantity(scanner);
        int price = readPrice(scanner);

        int total = calculateTotal(quantity, price);

        displayResult(productName, quantity, price, total);

        scanner.close();
    }

    private static String readProductName(Scanner scanner) {
        while (true) {
            System.out.print("商品名を入力してください: ");
            String input = scanner.nextLine();
            if (input != null && !input.isBlank()) {
                return input;
            }
            System.out.println("入力エラー: 商品名は必須です");
        }
    }

    private static int readQuantity(Scanner scanner) {
        while (true) {
            try {
                System.out.print("個数を入力してください: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                validateQuantity(quantity);
                return quantity;
            } catch (NumberFormatException e) {
                System.out.println("入力エラー: 数字を入力してください");
            } catch (IllegalArgumentException e) {
                System.out.println("入力エラー: " + e.getMessage());
            }
        }
    }

    private static int readPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("値段を入力してください（円）: ");
                int price = Integer.parseInt(scanner.nextLine());
                validatePrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("入力エラー: 数字を入力してください");
            } catch (IllegalArgumentException e) {
                System.out.println("入力エラー: " + e.getMessage());
            }
        }
    }

    private static void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("個数は正の数を入力してください");
        }
        if (quantity >= 100) {
            throw new IllegalArgumentException("個数は99個以下にしてください");
        }
    }

    private static void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("値段は正の数を入力してください");
        }
        if (price >= 10000) {
            throw new IllegalArgumentException("値段は9999円以下にしてください");
        }
    }

    private static int calculateTotal(int quantity, int price) {
        return quantity * price;
    }

    private static void displayResult(String name, int quantity, int price, int total) {
        System.out.println("----- 計算結果 -----");
        System.out.println("商品名: " + name);
        System.out.println("個数: " + quantity);
        System.out.println("値段: " + price + "円");
        System.out.println("合計金額: " + total + "円");
    }
}
/*メソッド分割により可読性向上
また不正な値が入力された場合は繰り返し処理にてもう一度入力を促す仕様に変更 */
