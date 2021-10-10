package dao;

import java.util.List;

import utility.Covid19;

public interface Covid19DAO {

	List<Covid19> getAllStatesCovid19();

	List<Covid19> getGlobalCovid19();

	List<Covid19> getIndiaCovid19();

}
