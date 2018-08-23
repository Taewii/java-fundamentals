package hell;

import hell.core.EngineImpl;
import hell.data.HeroRepository;
import hell.factories.CommonItemFactoryImpl;
import hell.factories.HeroFactoryImpl;
import hell.factories.RecipeFactoryImpl;
import hell.interfaces.*;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter writer = new ConsoleWriter();
        Repository heroes = new HeroRepository();
        HeroFactory heroFactory = new HeroFactoryImpl();
        CommonItemFactory itemFactory = new CommonItemFactoryImpl();
        RecpieFactory recpieFactory = new RecipeFactoryImpl();

        Engine engine = new EngineImpl(reader, writer, heroes, heroFactory, itemFactory, recpieFactory);

        engine.run();
    }
}