import React from "react";
import { Box, Typography } from "@mui/material";
import Slider from "react-slick";

import bridge from "../../asset/bridge-6314795_1280.jpg";
import venatge from "../../asset/vw-1835506_1280.jpg";
import travell from "../../asset/max-di-capua-S1O5ntrjkgc-unsplash.jpg";

export const HeroSection = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    fade: true,
    autoplay: true,
    autoplaySpeed: 4000,
    arrows: false,
  };

  const slides = [bridge, venatge, travell];

  return (
    <Box sx={{ position: "relative", width: "100%", height: "100vh", overflow: "hidden" }}>
      <Slider {...settings}>
        {slides.map((img, index) => (
          <div key={index}>
            <Box
              sx={{
                backgroundImage: `url(${img})`,
                backgroundSize: "cover",
                backgroundPosition: "center",
                width: "100%",
                height: "100vh",
              }}
            />
          </div>
        ))}
      </Slider>

      {/* Dark overlay */}
      <Box
        sx={{
          position: "absolute",
          top: 0,
          left: 0,
          width: "100%",
          height: "100%",
          backgroundColor: "rgba(0, 0, 0, 0.5)",
          zIndex: 1,
        }}
      />

      {/* Centered Text */}
      <Box
        sx={{
          position: "absolute",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
          textAlign: "center",
          color: "#fff",
          zIndex: 2,
          px: 2,
        }}
      >
        <Typography
          variant="h2"
          sx={{
            fontWeight: "bold",
            mb: 2,
            fontSize: { xs: "2rem", sm: "3rem", md: "4rem" },
          }}
        >
          Your Journey, Your Way!
        </Typography>
        <Typography
          variant="h5"
          sx={{
            mb: 4,
            fontSize: { xs: "1rem", sm: "1.3rem", md: "1.5rem" },
          }}
        >
          Find the best rental deals, hit the road, and explore with ease!
        </Typography>
      </Box>
    </Box>
  );
};
