import React, {useState, useEffect} from 'react';
import axios from 'axios';
import './Videos.css';
import { Link } from "react-router-dom";

export default function AllVideos() {

    const [allVideos, setAllVideos] = useState([]);

    useEffect(() => {
        async function getVideos() {
            const response = await axios.get(
                "http://localhost:8081/video-service/videos"
            );
            setAllVideos(response.data);
            console.log(response.data);
        }
        getVideos();
    }, []);

    return (
        <div>
            {allVideos.map(video => (
            <div className="container">
                <div className="row">    
                    <div className="col-md-12">
                        <div className="card">
                            <div className="card-image">
                                <div className="embed-responsive embed-responsive-16by9">
                                    <iframe title = {video.id} width="560" height="315" src={video.url} 
                                    frameBorder="0" 
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                                    allowFullScreen>                       
                                    </iframe>
                                </div>                           
                            </div>
                            <Link to={`/video/${video.id}`}>
                                <div className="card-content">
                                    <span className="card-title">{video.name}</span>                                                    
                                </div>  
                            </Link>
                        </div>
                    </div>
                </div>
            </div>    
            ))}
        </div>
    )
}
