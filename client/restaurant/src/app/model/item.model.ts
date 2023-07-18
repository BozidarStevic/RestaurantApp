export class Item implements ItemInterface{
	public id?: number;
	public name: string;
	public category: CategoryInterface;
	public price: number;
		
	constructor(itemCfg:ItemInterface)
	{
		this.id = itemCfg.id;
		this.name = itemCfg.name;
		this.category = itemCfg.category;
		this.price = itemCfg.price;
	}
}

interface ItemInterface{
	id?: number;
	name: string;
	category: CategoryInterface;
	price: number
}

export interface CategoryInterface{
	id?: number;
	name?: string;
}

export class User implements UserInterface{
	public id?: number;
	public username: string;
	public password: string;
		
	constructor(userCfg:UserInterface)
	{
		this.id = userCfg.id;
		this.username = userCfg.username;
		this.password = userCfg.password;
	}
}
interface UserInterface{
	id?: number;
	username: string;
	password: string;
}