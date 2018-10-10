package com.learning.model;

public class Employee implements Comparable<Employee> {

	private int enumber;
	private String ename;
	private int salary;

	public Employee(int enumber, String ename, int salary) {
		super();
		this.enumber = enumber;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [enumber=" + enumber + ", ename=" + ename + ", salary=" + salary + "]";
	}

	public int getEnumber() {
		return enumber;
	}

	public void setEnumber(int enumber) {
		this.enumber = enumber;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {

		if (this.enumber == o.enumber)
			return 0;

		else
			return this.getEname().compareTo(o.getEname());

	}

}
