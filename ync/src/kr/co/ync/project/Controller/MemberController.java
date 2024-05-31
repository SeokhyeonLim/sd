package kr.co.ync.project.Controller;

import kr.co.ync.project.Controller.listener.MemberListener;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
    private List<MemberListener> memberListeners = new ArrayList<>();

    private static final MemberController instance = new MemberController();

    private MemberController(){

    }

    public static MemberController getInstance(){
        return instance;
    }

    public synchronized void addMemberListener(MemberListener memberListener){
        if (!memberListeners.contains(memberListener)) {
            memberListeners.add(memberListener);
        }
    }
}
