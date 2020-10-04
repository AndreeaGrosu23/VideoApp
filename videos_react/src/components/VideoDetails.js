import React, {useState, useEffect} from 'react';
import axios from 'axios';
import './Videos.css';
import { useHistory } from "react-router";

export default function VideoDetails({ id }) {

    const [videoDetails, setVideoDetails] = useState([]);
    const [videoRecommendations, setVideoRecommendations] = useState([]);
    const [rating, setRating] = useState();
    const [comment, setComment] = useState();
    const history = useHistory();


    useEffect(() => {
        async function getVideoDetails() {
            const response = await axios.get(
                `http://localhost:8081/video-service/video/${id}`
            );
            setVideoDetails(response.data);
            setVideoRecommendations(response.data.videoRecommendationsList);
            console.log(response.data);
            console.log(response.data.videoRecommendationsList)
        }
        getVideoDetails();
    }, [id]);
   
    const saveRecommendation = (e) => {
        e.preventDefault();
        const data = { rating : rating, comment : comment};
        console.log(data)
        axios.post(`http://localhost:8081/video-service/add-recommendation/${id}`, data);
        history.push("/");
    }

    return (
        <div>
            <div className="container">
                <div className="row">    
                    <div className="col-md-12">
                        <div className="card">
                            <div className="card-image">
                                <div className="embed-responsive embed-responsive-16by9">
                                    <iframe title = {videoDetails.id} width="560" height="315" src={videoDetails.url} 
                                    frameBorder="0" 
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                                    allowFullScreen>                       
                                    </iframe>
                                </div>                           
                            </div>
                            <div className="card-content">
                                <span className="card-title">{videoDetails.name}</span>                                                    
                            </div>  
                            <div>
                                <h5 style = {{ color : "blue" }}>Comments:</h5>
                                {videoRecommendations.map(recommendation => (
                                <h6 style = {{ color : "darkBlue" }}>{recommendation.comment} | Rating: {recommendation.rating}</h6>
                                ))}               
                            </div>
                            <form onSubmit={saveRecommendation}>
                                <div className="form-group">
                                    <label for="exampleFormControlTextarea1">Add comment</label>
                                    <textarea 
                                    className="form-control" 
                                    id="exampleFormControlTextarea1" 
                                    rows="3"
                                    value={comment}
                                    onChange = {e => setComment(e.currentTarget.value)}
                                    >
                                    </textarea>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Rating</label>
                                    <select 
                                    className="form-control" 
                                    id="exampleFormControlSelect1"
                                    value = {rating}
                                    onChange = {e => setRating(e.currentTarget.value)}
                                    >
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    </select> 
                                </div>
                                <button type="submit" class="btn btn-primary">Add</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    )
}