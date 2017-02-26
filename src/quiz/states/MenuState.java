package quiz.states;

import graphics.Menu;
import quiz.Handler;

public class MenuState {

    private Menu menu;
    private Handler handler;

    public MenuState(Menu menu, Handler handler){
        this.menu = menu;
        this.handler = handler;

        addMenuToDisplay();
    }

    private void addMenuToDisplay(){
        handler.getDisplay().add(menu);
    }

    public void hideMenu(){
        menu.setVisible(false);
    }

    public void showMenu(){
        menu.updateHistory();
        menu.setVisible(true);
    }

    public Menu getMenu(){
        return menu;
    }

}
