package com.test.model;

import java.util.Objects;

public class Jobs {
    private int jobId;
    private String jobName;
    private int minSal;
    private int maxSal;

    public Jobs() {
    }

    public Jobs(int jobId, String jobName, int minSal, int maxSal) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getMinSal() {
        return minSal;
    }

    public void setMinSal(int minSal) {
        this.minSal = minSal;
    }

    public int getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(int maxSal) {
        this.maxSal = maxSal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jobs)) return false;
        Jobs jobs = (Jobs) o;
        return getJobId() == jobs.getJobId() &&
                getMinSal() == jobs.getMinSal() &&
                getMaxSal() == jobs.getMaxSal() &&
                Objects.equals(getJobName(), jobs.getJobName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobId(), getJobName(), getMinSal(), getMaxSal());
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", minSal=" + minSal +
                ", maxSal=" + maxSal +
                '}';
    }
}
