# Spring AI Workflow

A Spring Boot application that demonstrates AI-powered workflow processing using Spring AI with Groq's API.

## Overview

This project showcases a multi-step AI workflow that processes user input through sequential AI operations:
1. **Summarization**: Condenses text into 1-2 sentences
2. **Key Points Extraction**: Identifies 3-4 main points as bullet points
3. **Question Generation**: Creates 3 thoughtful follow-up questions

## Features

- 🤖 Integration with Groq AI using Spring AI framework
- 🔄 Sequential workflow processing (chain of AI operations)
- 🚀 RESTful API endpoint for easy integration
- ⚡ Fast inference using Groq's optimized LLM infrastructure
- 🎯 Uses Llama 3.3 70B model for high-quality responses

## Tech Stack

- **Java 22**
- **Spring Boot 3.4.1**
- **Spring AI 1.0.0-M4**
- **Groq API** (OpenAI-compatible endpoint)
- **Maven** for dependency management

## Prerequisites

- Java 22 or higher
- Maven 3.6+
- Groq API key (get one from [https://console.groq.com](https://console.groq.com))

## Setup

### 1. Clone the repository

```bash
git clone <repository-url>
cd spring-ai-workflow
```

### 2. Configure API Key

Copy the example configuration file:

```bash
cp src/main/resources/application.yaml.example src/main/resources/application.yaml
```

Edit `src/main/resources/application.yaml` and add your Groq API key:

```yaml
spring:
  ai:
    openai:
      api-key: ${GROQ_API_KEY:your-groq-api-key-here}
```

**Option 1**: Set as environment variable (recommended)
```bash
export GROQ_API_KEY=your-actual-api-key
```

**Option 2**: Replace `your-groq-api-key-here` directly in the file (not recommended for production)

### 3. Build the project

```bash
mvn clean install
```

### 4. Run the application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Usage

### Endpoint: POST /workflow

Process text through the AI workflow.

**Request:**
```bash
curl -X POST "http://localhost:8080/workflow?input=Artificial intelligence is transforming industries worldwide. Machine learning algorithms can now process vast amounts of data to identify patterns and make predictions. This technology is being applied in healthcare, finance, transportation, and many other sectors."
```

**Response:**
```
Step: Summarize the following text in 1-2 sentences.
Response: Artificial intelligence is revolutionizing various industries through machine learning algorithms...

Step: Extract 3-4 key points from text as bullet points.
Response: 
• AI is transforming multiple industries globally
• Machine learning processes large datasets for pattern recognition
• Applications span healthcare, finance, and transportation
• Predictive capabilities are a key feature

Step: Generate 3 thoughtful follow-up questions.
Response:
1. What are the ethical implications of AI decision-making in healthcare?
2. How can we ensure AI algorithms remain unbiased when processing data?
3. What skills will workers need to adapt to AI-driven industries?
```

## Project Structure

```
spring-ai-workflow/
├── src/
│   ├── main/
│   │   ├── java/hope/com/springaiworkflow/
│   │   │   ├── SpringAiWorkflowApplication.java
│   │   │   ├── controller/
│   │   │   │   └── WorkflowController.java
│   │   │   └── service/
│   │   │       └── WorkflowService.java
│   │   └── resources/
│   │       ├── application.yaml
│   │       └── application.yaml.example
│   └── test/
├── pom.xml
└── README.md
```

## Configuration Options

### Available Groq Models

You can change the model in `application.yaml`:

- `llama-3.3-70b-versatile` (default) - Best for general tasks
- `llama-3.1-70b-versatile` - Alternative large model
- `mixtral-8x7b-32768` - Good for longer contexts
- `gemma2-9b-it` - Faster, smaller model

### Temperature Setting

Adjust creativity (0.0 - 2.0):
- Lower (0.0-0.3): More focused and deterministic
- Medium (0.4-0.7): Balanced
- Higher (0.8-2.0): More creative and varied

## Development

### Running Tests

```bash
mvn test
```

### Building JAR

```bash
mvn clean package
java -jar target/spring-ai-workflow-1.0-SNAPSHOT.jar
```

## Security Notes

⚠️ **Important**: Never commit your `application.yaml` file with real API keys to version control!

- The `.gitignore` file is configured to exclude `application.yaml`
- Use environment variables for production deployments
- Use `application.yaml.example` as a template

## License

This project is licensed under the MIT License.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

