package com.modernjava.textblocks;

public class TextBlocks {



    public static String multiLineString() {

        var multiLine = "This is a\n" +
                "    multiline string\n" +
                "with newlines inside";

        return  multiLine;
    }

    public static String multiLineStringTextBlocks() {

        var multiLine = """
                This is a
                    multiline string
                with newlines inside
                """;

        return  multiLine;
    }

    public static String multiLineStringTextBlocksWithFormat() {
        var inString = "\n\tAnd this is a string added in the middle\n";
        var multiLine = """
                This is a
                    multiline string <%s>
                with newlines inside
                """.formatted(inString);

        return  multiLine;
    }

    public static String sqlGeneration (String param1, String param2){
        var multiline = """
                SELECT name, surname, department, rank, responsible_id
                    FROM employees
                    WHERE name = "%s" AND surname = "%s"
                    ORDER BY department, surname, name, rank;
                """.formatted(param1, param2);
        return multiline;
    }

    public static String jsonGeneration (String param1, String param2, double param3, char currency) {
        var multiline= """
                {
                "order_id"    : %s,
                "status"      : "%s",
                "final_price" : %c%.2f"
                }
                """.formatted(param1, param2, currency, param3);
        return multiline;
    }

    public static void main(String[] args) {

        System.out.println("multiLineString = " + multiLineString());
        System.out.println("multiLineStringTextBlocks = " + multiLineStringTextBlocks());
        System.out.println("multiLineStringTextBlocksWithFormat = " + multiLineStringTextBlocksWithFormat());
        System.out.println("sqlGeneration: \n" + sqlGeneration("Nombre", "Apellido"));
        System.out.println("jsonGeneration: \n" + jsonGeneration("12345", "DISPATCHED", 127.50, '¥'));
    }
}
