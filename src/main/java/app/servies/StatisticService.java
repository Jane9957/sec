package app.servies;

import app.dataBase.DataBaseStatistic;
import app.servies.entities.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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

}
