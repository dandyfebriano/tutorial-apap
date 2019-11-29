import React, { Component } from 'react';

import Store from "../../components/Store/Store";
import classes from "./Stores.module.css";
import axios from "../../axios-store";
import Modal from "../../components/UI/Modal/Modal";
import Button from "../../components/UI/Button/Button";

class Stores extends Component{
    constructor(props){
        super(props);
        this.state = {
            stores: [],
            isCreate: false,
            isEdit: false,
             isLoading: true,
            nama: "",
            keterangan: "",
            followers: "",
            search: ""

        };
    }

    updateSearch(event){
        this.setState({search : event.target.value.substr(0,20)});
    }

    editStoreHandler(store){
        this.setState({
            isEdit: true,
            id: store.id,
            nama: store.nama,
            keterangan: store.keterangan,
            followers: store.followers
        });
    }

    addStoreHandler = () => {
        this.setState({isCreate : true});
    };

    canceledHandler = () => {
        this.setState({ isCreate: false, isEdit: false});
    };
    
    componentDidMount(){
        this.loadStores();
    }


    loadStores = async () => {
        const fetchedStores = [];
        const response = await axios.get("/stores");
        for (let key in response.data){
            fetchedStores.push({
                ...response.data[key]
            });
        }
        this.setState({
            stores: fetchedStores
        });
    };

    async deleteStoreHandler(storeId){
        await axios.delete(`/store/${storeId}`);
        await this.loadStores();
    }

    render(){
        let filteredStore = this.state.stores.filter(
            (store) =>{
                return store.nama.toLowerCase().indexOf(this.state.search.toLowerCase())!== -1;
            }  
        );  
        return(
            <React.Fragment>
                <Modal show={this.state.isCreate || this.state.isEdit}
                modalClosed={this.canceledHandler}>
                    {this.renderForm()}
                </Modal>
                <div>Hello! Welcome to Shapee</div>
                 
                <div className = {classes.Title}>All Stores</div>
                <div className = {classes.ButtonLayout}>
                    <button className={classes.AddStoreButton}
                     onClick={this.addStoreHandler}>
                        + Add New Store
                    </button><br></br><br></br>Search:
                    <input type="text" value={this.state.search} onChange={this.updateSearch.bind(this)} />
                </div>
                <div className = {classes.Stores}> 
                    {filteredStore   && filteredStore.map(store =>
                        <Store
                            key={store.id}
                            nama={store.nama}
                            followers={store.followers}
                            keterangan={store.keterangan}
                            edit={() => this.editStoreHandler(store)}
                            delete={() => this.deleteStoreHandler(store.id)}
                            />
                    )}
                </div>
            </React.Fragment> 
        );
    }

    changeHandler = event => {
        const{name, value} = event.target;
        this.setState({[name] : value});
    };

    submitAddStoreHandler = event => {
        event.preventDefault();
        this.setState({ isLoading: true});
        this.addStore();
        this.canceledHandler();
    };

    async addStore(){
        const storeToAdd = {
            nama: this.state.nama,
            followers: this.state.followers,
            keterangan: this.state.keterangan
        };

        await axios.post("/store", storeToAdd);
        await this.loadStores();
        this.setState({nama: "", followers: "", keterangan:""});
    }

    submitEditStoreHandler = event => {
        event.preventDefault();
        this.setState({isLoading : true});
        this.editStore();
        this.canceledHandler();
    };

    async editStore(){
        const storeToEdit = {
            id: this.state.id,
            nama: this.state.nama,
            followers: this.state.followers,
            keterangan: this.state.keterangan
        };

        await axios.put("/store/" + this.state.id, storeToEdit);
        await this.loadStores();
    }    

    renderForm(){
        const { isEdit } = this.state;
        return(
            <form>
                <input
                    className={classes.Input}
                    name="nama"
                    type="text"
                    placeholder="Name"
                    value = {this.state.nama}
                    onChange={this.changeHandler}
                />
                <input
                    className={classes.Input}
                    name="followers"
                    type="numbers"
                    placeholder="Followers"
                    value= {this.state.followers}
                    onChange={this.changeHandler}
                />
                <textarea
                    className={classes.textarea}
                    name="keterangan"
                    type="text"
                    placeholder="Description"
                    value={this.state.keterangan}
                    onChange={this.changeHandler}
                />
                <Button btnType="Danger" onClick={this.canceledHandler}>
                    CANCEL
                </Button>
                <Button btnType="Success" onClick={
                    isEdit ? this.submitEditStoreHandler : this.submitAddStoreHandler}>
                    SUBMIT
                </Button>
            </form>
        );
    }
}

export default Stores;