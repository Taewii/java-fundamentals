package paw.core;

import paw.io.ConsoleReader;
import paw.io.ConsoleWriter;

import java.io.IOException;

public class Engine {

    private ConsoleReader reader;
    private ConsoleWriter writer;
    private AnimalCenterManager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new AnimalCenterManager();
    }

    public void run() {
        while (true) {
            String[] args = this.reader.readLine().split(" \\| ");

            switch (args[0]) {
                case "RegisterCleansingCenter":
                    this.manager.registerCleansingCenter(args[1]);
                    break;
                case "RegisterAdoptionCenter":
                    this.manager.registerAdoptionCenter(args[1]);
                    break;
                case "RegisterCastrationCenter":
                    this.manager.registerCastrationCenter(args[1]);
                    break;
                case "RegisterDog":
                    this.manager.registerDog(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4]);
                    break;
                case "RegisterCat":
                    this.manager.registerCat(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4]);
                    break;
                case "SendForCleansing":
                    this.manager.sendForCleansing(args[1], args[2]);
                    break;
                case "SendForCastration":
                    this.manager.sendForCastration(args[1], args[2]);
                    break;
                case "Cleanse":
                    this.manager.cleanse(args[1]);
                    break;
                case "Castrate":
                    this.manager.castrate(args[1]);
                    break;
                case "Adopt":
                    this.manager.adopt(args[1]);
                    break;
                case "Paw Paw Pawah":
                    this.writer.write(this.manager.printStatistics());
                    return;
            }
        }
    }
}
