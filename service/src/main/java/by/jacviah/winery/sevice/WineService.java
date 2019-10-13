package by.jacviah.winery.sevice;

import by.jacviah.winery.model.Bottle;
import by.jacviah.winery.model.Wine;
import by.jacviah.winery.dao.exception.DaoException;

import java.util.List;

public interface WineService {
    public Wine findWine(String name, String winery) throws DaoException;
    public List<Bottle> getAllBottles(String login) throws DaoException;
    public Wine addBottle(Bottle bottle) throws DaoException;
}