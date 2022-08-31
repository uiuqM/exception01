package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o numero do quarto: ");
		int num = sc.nextInt();
		System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("A data de check-out tem que ser pos check-in!");
		}
		else {
			Reservation reservation = new Reservation(num, checkin, checkout);
			System.out.println("Reserva: "+reservation);
			
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date agora = new Date();
			
			if (checkin.before(agora) || checkout.before(agora)) {
				System.out.println("As novas datas tem que ser futuras!");
			}
			else if(!checkout.after(checkin)){
				System.out.println("A data de check-out tem que ser pos check-in!");
			}
			else {
				reservation.updateDate(checkin, checkout);
				System.out.println("Reserva: "+reservation);
			}
		}
		sc.close();
	}

}
