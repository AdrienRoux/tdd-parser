package org.example;

import java.util.Arrays;

public class Args {

    private String schema;
    private String[] args;

    public Args(String schema, String[] args) {
        this.schema = schema;
        this.args = args;
        System.out.println(Arrays.toString(args));
    }

    public boolean getBoolean(char flag) {
        for (String arg : this.args) {
            if (arg.equals("-" + flag)) return true;
        }
        return false;
    }
    public int getInt(char flag) throws ArgsException {
        int result = 0;
        if (flagHasValue(flag)) {
                try {
                    result = Integer.parseInt(getFlagValue(flag));
                } catch (NumberFormatException e) {
                    throw new ArgsException("Expected a number.");
                }
        }
        return result;
    }
    public String getString(char flag) throws ArgsException {
        String result = "";
        if (flagHasValue(flag)) {
            result = getFlagValue(flag);
        }
        return result;
    }

    boolean flagHasValue(char flag) {
        for (int i = 0; i < this.args.length; i++) {
            if (argEqualsCLIArg(flag, args[i]) && i + 1 < this.args.length && !args[i+1].startsWith("-")) return true;
        }
        return false;
    }

    String getFlagValue(char flag) {
        String value = null;
        for (int i = 0; i < this.args.length; i++) {
            if (argEqualsCLIArg(flag, args[i]) && i + 1 < this.args.length && !args[i+1].startsWith("-"))
                value = args[i + 1];
        }
        return value;
    }

    boolean argEqualsCLIArg(char flag, String arg) {
        return arg.equals("-" + flag);
    }
}
