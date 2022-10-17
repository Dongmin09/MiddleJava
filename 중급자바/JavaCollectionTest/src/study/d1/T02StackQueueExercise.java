package study.d1;

import java.util.LinkedList;

public class T02StackQueueExercise {
public static void main(String[] args) {
	
	
	
	LinkedList<String> stack = new LinkedList<String>();
	
	
	stack.push("떳다떳다");
	stack.push("비행기");
	stack.push("날아라");
	
	System.out.println("현재 stack 값" + stack);

	String music = stack.pop();
	
	System.out.println("꺼내온 자료 :" + music);
	System.out.println("꺼내온 자료 :" + stack.pop());
	System.out.println("현재 stack 값" + stack);

	stack.push("대나무헬리콥터");
	
	System.out.println("현재 stack:" + stack);
	System.out.println("꺼낸 데이터:" + stack.pop());
	
	
	
	LinkedList<String> queue = new LinkedList<String>();

	
	queue.offer("범인은");
	queue.offer("이안에");
	queue.offer("있어");
	queue.offer("범인은 바로");
	
	
	System.out.println("현재 queue 값" + queue);
	
	String people = queue.poll();
	
	System.out.println("꺼낸 데이터" + people);
	System.out.println("꺼낸 데이터" + queue.poll());
	System.out.println("현재 queue 값" + queue);
	
	if(queue.offer("코난")) {
		
		
		System.out.println("신규 입력 데이터 코난" );
		
	}
	
	System.out.println("현재 queue 값" + queue);
	
	System.out.println("꺼넨 데이터: " + queue.poll());
	
	
	
}
}
