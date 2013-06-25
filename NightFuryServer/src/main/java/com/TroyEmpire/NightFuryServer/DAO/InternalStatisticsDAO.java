package com.TroyEmpire.NightFuryServer.DAO;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.InternalStatistics;
import com.TroyEmpire.NightFuryServer.IDAO.IInternalStatisticsDAO;


@Component
public class InternalStatisticsDAO extends DAO<InternalStatistics, Integer>
		implements IInternalStatisticsDAO {

}
