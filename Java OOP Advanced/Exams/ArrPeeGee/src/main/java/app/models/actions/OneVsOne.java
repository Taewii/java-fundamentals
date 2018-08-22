package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

import static app.models.Constants.EXACTLY_TWO_PARTICIPANTS_NEEDED;
import static app.models.Constants.WINNER_STRING;

public class OneVsOne implements Action {

    public String executeAction(List<Targetable> participants) {
        StringBuilder sb = new StringBuilder();

        if (participants.size() != 2) {
            sb.append(EXACTLY_TWO_PARTICIPANTS_NEEDED);
            return sb.toString();
        }

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        if (firstHero.isAlive()) {
            sb.append(String.format(WINNER_STRING, firstHero.getName(), System.lineSeparator(), firstHero.toString()));
        } else {
            sb.append(String.format(WINNER_STRING, firstHero.getName(), System.lineSeparator(), firstHero.toString()));
        }

        return sb.toString();
    }
}
