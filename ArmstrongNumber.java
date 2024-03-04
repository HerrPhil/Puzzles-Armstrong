public class ArmstrongNumber {

    public static void main(String [] args) {
        System.out.println("Hello Armstrong Number"); // Hello armstrong numbers
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java ArmstrongNumber <input>%n");
            return;
        }
        if (args == null || args.length == 0) {
            System.out.printf("Number to check for Armstrong is mandatory%n");
            return;
        }
        String input = args[0];
        ArmstrongNumber myNumber = new ArmstrongNumber(args[0]);
        boolean isArmstrongNumber = myNumber.isArmstrongNumber();
        if (isArmstrongNumber) {
            System.out.printf("%s is an Armstrong number%n", input );
        } else {
            System.out.printf("%s is not an Armstrong number%n", input);
        }
    }

    public ArmstrongNumber(String value) {
        this.value = value;
    }

    private String value;

    boolean isArmstrongNumber() {
        boolean hasDigitsOnly = value.matches("-?\\d+");
        if (!hasDigitsOnly) {
            System.out.printf("%s is not a number%n", value);
            return hasDigitsOnly;
        }
        // Utilize regex special construct zero-width positive lookbehind
        String [] digits = value.split("(?<=.)");
        int armstrongNumber = 0;
        int exponent = digits.length;
        System.out.printf("exponent (number of digits) is %d%n", exponent);
        for (int i = 0; i < exponent; i++) {
            System.out.printf("digit %s%n", digits[i]);
            armstrongNumber += Math.pow(Integer.valueOf(digits[i]), exponent);
        }
        System.out.printf("Armstrong number value is %d%n", armstrongNumber);
        return Integer.valueOf(value).equals(armstrongNumber);
    }
}
