package app.servies;

import app.dataBase.DataBaseStatistic;
import app.servies.entities.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class StatisticService {

    @Autowired
    private DataBaseStatistic dataBaseStatistic;

    public Statistic getStatistic() {
        Statistic statistic = new Statistic();
        try {
            statistic.setAttackTotal(dataBaseStatistic.getAttackTotal());
            statistic.setAttackedUsersTotal(dataBaseStatistic.getAttackedUserTotal());
            statistic.setAttackedUsersURL(dataBaseStatistic.getAttackedUserURL());
            statistic.setAttackedUsersForm(dataBaseStatistic.getAttackedUserForm());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return statistic;
    }

    public Map<String, Float> getPercentLast5AttacksURL() {
        Map<String, Float> map = new HashMap<>();
        try {
            map = dataBaseStatistic.getPercentLast5AttacksURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Float> getPercentLast5AttacksForm() {
        Map<String, Float> map = new TreeMap<>();
        try {
            map = dataBaseStatistic.getPercentLast5AttacksForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Integer> getPieChart() {
        Map<String, Integer> map = new TreeMap<>();
        try {
            map.put("URL", dataBaseStatistic.getAttackedUserForm());
            map.put("FORM", dataBaseStatistic.getAttackedUserForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
