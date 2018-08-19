package p04_word_force.jobs;

import java.util.LinkedHashMap;
import java.util.Map;

public class JobCollection {

    private Map<String, Job> jobs;

    public JobCollection() {
        this.jobs = new LinkedHashMap<>();
    }

    public void addJob(Job job) {
        this.jobs.put(job.getName(), job);
    }

    public void weekPassed() {
        var iterator = this.jobs.values().iterator();

        while (iterator.hasNext()) {
            Job job = iterator.next();
            job.update();

            if (job.getHoursOfWorkRequired() <= 0) {
                System.out.println(String.format("Job %s done!", job.getName()));
                iterator.remove();
            }
        }
    }

    public String status() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Job job : jobs.values()) {
            stringBuilder.append(String.format("Job: %s Hours Remaining: %d", job.getName(), job.getHoursOfWorkRequired()))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
