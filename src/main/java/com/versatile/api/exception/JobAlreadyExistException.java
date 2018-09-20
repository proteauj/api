package com.versatile.api.exception;

public class JobAlreadyExistException extends Throwable {
    public JobAlreadyExistException(Integer idCar, Integer idJob) {
        super("Job with car " + idCar + " and status NEW already exist " + idJob);
    }
}
