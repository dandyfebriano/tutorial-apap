import React from 'react';
import List from "./components/List";
import dummyItems from "./items.json";
import EmptyState from './components/EmptyState';


export default class App extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      favItems:[], checked : false
      ,dark : false
    };
    // this.state = {checked : false}
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(){
    this.setState({
      checked: !this.state.checked
    })
  }

  setTheme = () => {
    if(this.state.dark == '#000000'){
      this.setState({
        dark: '#ffffff'
      })
    }
    else{
      this.setState({
        dark: '#000000'
      })
    }
  }

  handleItemClick = item =>{
    const newItems = [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if(targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);
    this.setState({ favItems: newItems});
  };

  handleItemClickLeft = item =>{
    const newItems = [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if(targetInd < 0) newItems.push(newItem);
    this.setState({ favItems: newItems});
  };

  render(){
    const{ favItems } = this.state;
    const content = 
    <div className="col-sm">
    <List
      checkbox={true}
      title="My Favorite"
      items={favItems}
      onItemClick={this.handleItemClick}
      />
    </div>
    const fav = this.state.checked ? favItems.length >0 ?content : <EmptyState/> : null;

    return(
      <div className="container-fluid" style = {{backgroundColor : this.state.dark}}  >
        <h1 className="text-center">
          Welcome!
          <small>Class-based</small>
        </h1>
        <button type = 'toggle' checked = {this.state.dark} onClick = {this.setTheme}>Ubah</button>
        <div>
        <label>Check</label>
        <input 
          type="checkbox" 
          checked={ this.state.checked } 
          onChange={ this.handleChange } />
      </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                checkbox = {false}
                title="Our Product"
                items={dummyItems}
                onItemClick={this.handleItemClickLeft}
                />
            </div>
            {fav}
            {/* <div className="col-sm">
              <List
                checkbox={true}
                title="My Favorite"
                items={favItems}
                onItemClick={this.handleItemClick}
                />
            </div> */}
          </div>
        </div>
      </div>
    );
  }
}



