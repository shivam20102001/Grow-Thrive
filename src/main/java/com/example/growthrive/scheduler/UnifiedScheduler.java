//package com.example.growthrive.scheduler;
//
//import com.example.growthrive.domain.Goal;
//import com.example.growthrive.domain.Health;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class UnifiedScheduler {
//
//    public static void startScheduler() {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//        scheduler.scheduleAtFixedRate(() -> {
//            System.out.println("Scheduler started at: " + LocalDateTime.now());
//            processGoals();
//            processHealthRoutines();
//        }, 0, 1, TimeUnit.DAYS); // Run daily
//    }
//
//    private static void processGoals() {
//        // Fetch overdue goals
//        List<Goal> overdueGoals = goalDao.fetchOverdueGoals();
//        for (Goal goal : overdueGoals) {
//            if (goal.getLastUpdated().isAfter(goal.getEndDate())) {
//                // Skip user-updated goals
//                continue;
//            }
//            if (!goal.isCompleted()) {
//                // Apply penalty or other logic
//                goal.setPoints(goal.getPoints() - penaltyPoints);
//                goalDao.updateGoal(goal);
//            }
//        }
//        System.out.println("Goals processed.");
//    }
//
//    private static void processHealthRoutines() {
//        // Fetch overdue health routines
//        List<Health> overdueRoutines = healthRoutineDao.fetchOverdueRoutines();
//        for (Health routine : overdueRoutines) {
//            if (routine.getLastUpdated().isAfter(routine.getEndDate())) {
//                // Skip user-updated routines
//                continue;
//            }
//            if (!routine.isCompleted()) {
//                // Apply penalty or notify user
//                routine.setMissedCount(routine.getMissedCount() + 1);
//                healthRoutineDao.updateRoutine(routine);
//            }
//        }
//        System.out.println("Health routines processed.");
//    }
//}
