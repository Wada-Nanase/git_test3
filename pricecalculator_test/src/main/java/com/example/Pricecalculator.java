package com.example;
import java.util.Scanner;
/**
 * Hello world!
 */
public class Pricecalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("商品名を入力してください: ");
            String productName = scanner.nextLine();

            if (productName == null || productName.isBlank()) {
                throw new IllegalArgumentException("商品名は必須です");
            }

            System.out.print("個数を入力してください: ");
            int quantity = scanner.nextInt();

            System.out.print("値段を入力してください（円）: ");
            int price = scanner.nextInt();

            validate(quantity, price);

            int total = quantity * price;

            // 結果表示
            System.out.println("----- 計算結果 -----");
            System.out.println("商品名: " + productName);
            System.out.println("個数: " + quantity);
            System.out.println("値段: " + price + "円");
            System.out.println("合計金額: " + total + "円");

        } catch (IllegalArgumentException e) {
            System.out.println("入力エラー: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("予期しないエラーが発生しました: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void validate(int quantity, int price) {
        if (quantity == 0 || price == 0) {
            throw new IllegalArgumentException("個数と値段に0は指定できません");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("個数は正の数を入力してください");
        }

        if (price < 0) {
            throw new IllegalArgumentException("値段は正の数を入力してください");
        }

        if (quantity >= 100) {
            throw new IllegalArgumentException("個数は99個以下にしてください");
        }

        if (price >= 10000) {
            throw new IllegalArgumentException("値段は9999円以下にしてください");
        }
    }
}

