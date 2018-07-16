package p04_telephony;

import p04_telephony.contracts.Browsable;
import p04_telephony.contracts.Callable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Callable phone1 = new Smartphone(reader.readLine());
        phone1.call();
        Browsable phone2 = new Smartphone(reader.readLine());
        phone2.browse();
    }
}
