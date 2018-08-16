package database;

import contracts.Repository;
import utility.Constants;
import contracts.Modelable;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;

public class RepositoryImpl<T extends Modelable> implements Repository {
    private HashMap<String, T> itemsByModel;

    public RepositoryImpl() {
        this.setItemsByModel(new HashMap<>());
    }

    protected HashMap<String, T> getItemsByModel() {
        return this.itemsByModel;
    }

    protected void setItemsByModel(HashMap<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void Add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }
}
