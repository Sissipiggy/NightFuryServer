package com.TroyEmpire.NightFuryServer.DAO;

import org.springframework.stereotype.Component;

import com.TroyEmpire.NightFuryServer.Entity.Bug;
import com.TroyEmpire.NightFuryServer.IDAO.IBugDAO;


@Component
public class BugDAO extends DAO<Bug, Integer> implements IBugDAO {
}
