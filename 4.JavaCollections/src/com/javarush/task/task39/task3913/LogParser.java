package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<File> logs;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        logs = findLogFile();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        ips.add(log.ip);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.user.equals(user)) {
                            ips.add(log.ip);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(event)) {
                            ips.add(log.ip);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if (isBetween2Date(log.date, after, before)) {
                        if (log.status.equals(status)) {
                            ips.add(log.ip);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ips;
    }


    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    users.add(log.user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        users.add(log.user);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.user.equals(user)) {
                            events.add(log.event);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.ip.equals(ip)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.LOGIN)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.DOWNLOAD_PLUGIN)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.WRITE_MESSAGE)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.SOLVE_TASK)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.SOLVE_TASK)) {
                            if (log.task == task) {
                                users.add(log.user);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.DONE_TASK)) {
                            users.add(log.user);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if (log.event.equals(Event.DONE_TASK)) {
                            if (log.task == task) {
                                users.add(log.user);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.user.equals(user) && log.event.equals(event)) {
                            dates.add(log.date);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.status.equals(Status.FAILED)) dates.add(log.date);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.status.equals(Status.ERROR)) dates.add(log.date);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date erlyerDate = null;

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.LOGIN) && log.user.equals(user)) {
                            if(erlyerDate != null) {
                                if(erlyerDate.getTime() > log.date.getTime()) erlyerDate = log.date;
                            } else {
                                erlyerDate = log.date;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return erlyerDate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date erlyerDate = null;
        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.SOLVE_TASK) && log.task == task && log.user.equals(user)) {
                            if(erlyerDate != null) {
                                if(erlyerDate.getTime() > log.date.getTime()) erlyerDate = log.date;
                            } else {
                                erlyerDate = log.date;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return erlyerDate;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date erlyerDate = null;
        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.DONE_TASK) && log.task == task && log.user.equals(user)) {
                            if(erlyerDate != null) {
                                if(erlyerDate.getTime() > log.date.getTime()) erlyerDate = log.date;
                            } else {
                                erlyerDate = log.date;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return erlyerDate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.WRITE_MESSAGE) && log.user.equals(user)) dates.add(log.date);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.DOWNLOAD_PLUGIN) && log.user.equals(user)) dates.add(log.date);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.ip.equals(ip)) events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.user.equals(user)) events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.status.equals(Status.FAILED)) events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.status.equals(Status.ERROR)) events.add(log.event);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int countOfAttempt = 0;

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.SOLVE_TASK) && log.task == task) countOfAttempt++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countOfAttempt;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int countOfAttempt = 0;

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.DONE_TASK) && log.task == task) countOfAttempt++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countOfAttempt;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.SOLVE_TASK)) {
                            int attampt = 1;
                            if(map.containsKey(log.task)) {
                                attampt = map.get(log.task);
                                map.put(log.task, ++attampt);
                            } else {
                                map.put(log.task, attampt);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();

        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    if(isBetween2Date(log.date, after, before)) {
                        if(log.event.equals(Event.DONE_TASK)) {
                            int attampt = 1;
                            if(map.containsKey(log.task)) {
                                attampt = map.get(log.task);
                                map.put(log.task, ++attampt);
                            } else {
                                map.put(log.task, attampt);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public Set<Status> getAllStatus() {
        Set set = new HashSet<>();
        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    set.add(log.status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }
    public Set<Date> getAllDate() {
        Set set = new HashSet<>();
        try {
            for (int i = 0; i < logs.size(); i++) {
                BufferedReader reader = new BufferedReader(new FileReader(logs.get(i)));
                while (reader.ready()) {
                    String str = reader.readLine();
                    Log log = new Log(str);
                    set.add(log.date);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }


    private boolean isBetween2Date(Date current, Date after, Date before) {

        if(after == null & before == null) {
            return true;
        }

        if(after == null & before != null) {
            if(current.getTime() <= before.getTime()) return true;
            else return false;
        }

        if(after != null & before == null) {
            if(current.getTime() >= after.getTime()) return true;
            else return false;
        }

        if(after != null & before != null) {
            if(current.getTime() <= before.getTime() & current.getTime() >= after.getTime()) {
                return true;
            } else return false;
        }

        return false;
    }

    private List<File> findLogFile() {
        List<File> list = new ArrayList<>();
        File[] files = logDir.toFile().listFiles();

        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()) {
                if(files[i].toString().endsWith(".log")) {
                    list.add(files[i]);
                }
            }
        }

        return list;
    }

    @Override
    public Set<Object> execute(String query) {
        Set set = new HashSet<>();

        switch (query) {
            case "get ip" :
                set = getUniqueIPs(null, null);
                break;

            case "get user" :
                set = getAllUsers();
                break;

            case "get date" :
                set = getAllDate();
                break;

            case "get event" :
                set = getAllEvents(null, null);
                break;

            case "get status" :
                set = getAllUsers();
                break;
        }

        return set;
    }


    private static class Log {
        private String str;

        private String ip;
        private String user;
        private Date date;
        private Event event;
        private int task = -1;
        private Status status;

        public Log(String str) {
            this.str = str;
            parseStr();
        }

        private void parseStr() {
            String[] piecesOfString = str.split("\t");

            ip = piecesOfString[0];
            user = piecesOfString[1];
            date = parseDate(piecesOfString[2]);
            parseEventAndTask(piecesOfString[3]);
            status = Status.valueOf(piecesOfString[4]);
        }

        private void parseEventAndTask(String s) {
            String[] strings = s.split(" ");
            event = Event.valueOf(strings[0]);
            if(strings.length > 1) {
                task = Integer.parseInt(strings[1]);
            }
        }


        private Date parseDate(String s) {
            String[] piecesOfString = s.split(" |:|\\.");
            int day = Integer.parseInt(piecesOfString[0]);
            int month = Integer.parseInt(piecesOfString[1]);
            int year = Integer.parseInt(piecesOfString[2]);
            int hour = Integer.parseInt(piecesOfString[3]);
            int minut = Integer.parseInt(piecesOfString[4]);
            int sec = Integer.parseInt(piecesOfString[5]);

            return new Date(year-1900, month-1, day, hour, minut, sec);
        }


        @Override
        public String toString() {
            return "Log{" + '\n' +
                    ", ip=" + ip + '\n' +
                    ", user=" + user + '\n' +
                    ", date=" + date + '\n' +
                    ", event=" + event + '\n' +
                    ", task=" + task + '\n' +
                    ", status=" + status + '\n' +
                    '}';
        }
    }

//    public static void main(String[] args) {
//        //LogParser parser = new LogParser(Paths.get("F:\\test"));
//        Date erlyerDate = new Date(100, 0, 0, 0, 0, 0);
//        System.out.println(erlyerDate.getTime());
//    }
}