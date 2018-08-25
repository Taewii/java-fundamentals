package callofduty.models.agents;

import callofduty.interfaces.BountyAgent;

public class MasterAgent extends BaseAgent implements BountyAgent {

    private Double bounty;

    public MasterAgent(String id, String name) {
        super(id, name);
        this.bounty = 0d;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }
}
