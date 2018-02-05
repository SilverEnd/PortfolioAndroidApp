package com.erikzuo.portfolioandroidapp.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by YifanZuo on 3/2/18.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
