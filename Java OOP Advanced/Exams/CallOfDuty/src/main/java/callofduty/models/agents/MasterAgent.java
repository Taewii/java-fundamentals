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

    protected void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("%nBounty Earned: $%.2f", this.getBounty()));

        return sb.toString();
    }
}
