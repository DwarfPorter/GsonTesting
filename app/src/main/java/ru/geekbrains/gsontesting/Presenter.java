package ru.geekbrains.gsontesting;

public class Presenter implements IPresenter{

    private ViewMainActivity mainActivity;
    private IRepository repository;

    public Presenter(ViewMainActivity mainActivity, IRepository repository){
        this.mainActivity = mainActivity;
        this.repository = repository;
    }

    public void save(){
        User user = new User();
        user.setName(mainActivity.getName());
        user.setSurname(mainActivity.getSurname());
        repository.insert(user);
    }

}
