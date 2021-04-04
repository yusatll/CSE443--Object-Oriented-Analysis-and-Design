package hw1_part2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Photo photo = new Photo();
        Audio audio = new Audio();
        Text text = new Text();

        Subscriber subs1 = new Subscriber();
        Subscriber subs2 = new Subscriber();
        Subscriber subs3 = new Subscriber();
        Subscriber subs4 = new Subscriber();
        Subscriber subs5 = new Subscriber();

        photo.registerObserver(subs1);  // Subs1 Registered to Photo
        photo.registerObserver(subs2);  // Subs2 Registered to Photo
        photo.registerObserver(subs4);  // Subs4 Registered to Photo

        audio.registerObserver(subs1);  // Subs1 Registered to Audio
        audio.registerObserver(subs3);  // Subs3 Registered to Audio
        audio.registerObserver(subs4);  // Subs4 Registered to Audio

        text.registerObserver(subs3);   // Subs3 Registered to Text
        text.registerObserver(subs4);   // Subs4 Registered to Text
        text.registerObserver(subs5);   // Subs5 Registered to Text
        System.out.println();

        audio.notifyToObservers();
        System.out.println();

        photo.notifyToObservers();
        System.out.println();

        text.notifyToObservers();
        System.out.println();


        audio.changeStringMessage("Change Audio Name");
        audio.notifyToObservers();
        System.out.println();

        text.changeStringMessage("Change Text Name");
        text.notifyToObservers();

        System.out.println();
        photo.deleteObserver(subs4);

        photo.changeStringMessage("Change Photo Name");
        photo.notifyToObservers();

    }
}
